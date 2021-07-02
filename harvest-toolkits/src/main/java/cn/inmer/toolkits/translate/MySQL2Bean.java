package cn.inmer.toolkits.translate;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import lombok.Data;

import java.io.File;
import java.util.*;

/**
 * mysql 表转实体 工具
 *
 * @author inmer
 * @version v1.0
 * @date 2021-06-29 10:12
 */
@Data
public class MySQL2Bean {
    private final String jdbc;
    private final String username;
    private final String password;
    
    private final Set<String> ignoreTableSet = new HashSet<>();
    private final Set<String> ignoreTableColSet = new HashSet<>();
    private final Set<String> createTableSet = new HashSet<>();
    private String basePackageName;
    
    public static void main(String[] args) {
        MySQL2Bean sql2Bean = new MySQL2Bean("jdbc:mysql://sh-cdb-a9xmt98u.sql.tencentcdb.com:60406/moore_access?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "bigdata", "bigdata123");
        sql2Bean.setBasePackageName("com.dtminds.bigdata.moore.api.opensdk.domain.order");
        sql2Bean.setBasePackageName("com.dtminds.bigdata.moore.api.opensdk.domain.user");
        sql2Bean.addCreateTable("ryytn_customer_order");
        sql2Bean.addCreateTable("ryytn_base_label");
        sql2Bean.addIgnoreTableCol("id");
        sql2Bean.addIgnoreTableCol("one_id");
        sql2Bean.addIgnoreTableCol("status");
        sql2Bean.addIgnoreTableCol("md5");
        sql2Bean.addIgnoreTableCol("ctime");
        sql2Bean.addIgnoreTableCol("utime");
        sql2Bean.addIgnoreTableCol("ct_user");
        sql2Bean.addIgnoreTableCol("up_user");
        sql2Bean.generate();
    }
    
    public MySQL2Bean(String jdbc, String username, String password) {
        this.jdbc = jdbc;
        this.username = username;
        this.password = password;
    }
    
    public void addIgnoreTable(String table) {
        ignoreTableSet.add(table);
    }
    
    public void addIgnoreTableCol(String col) {
        ignoreTableColSet.add(col);
    }
    
    public void addCreateTable(String table) {
        createTableSet.add(table);
    }
    
    public void generate() {
        //Step-1 连接库
        DruidPlugin druidPlugin = new DruidPlugin(jdbc, username, password);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        druidPlugin.start();
        activeRecordPlugin.start();
        
        //Step-2 查询列表
        for (String table : createTableSet) {
            Map<String, Object> model = new HashMap<>();
            model.put("baseModelPackageName", basePackageName);
            model.put("baseModelName", StrKit.firstCharToUpperCase(StrKit.toCamelCase(table.substring(table.indexOf("_")), false)));
            Set<String> imports = new HashSet<>();
            List<Map<String, Object>> columnMetas = new ArrayList<>();
            List<Record> records = Db.find("desc " + table);
            for (Record record : records) {
                Map<String, Object> col = new HashMap<>();
                String field = record.getStr("Field");
                String type = record.getStr("Type");
                String aDefault = record.getStr("Default");
                if (ignoreTableColSet.contains(field)) {
                    continue;
                }
                if (type.toLowerCase().contains("int")) {
                    col.put("type", "Integer");
                    col.put("defaultValue", aDefault);
                }
                if (type.toLowerCase().contains("bigint")) {
                    col.put("type", "Long");
                    col.put("defaultValue", aDefault + "L");
                }
                if (type.toLowerCase().contains("varchar")) {
                    col.put("type", "String");
                    col.put("defaultValue", "\"" + aDefault + "\"");
                    
                }
                if (type.toLowerCase().contains("char")) {
                    col.put("type", "String");
                    col.put("defaultValue", "\"" + aDefault + "\"");
                }
                if ("date".equalsIgnoreCase(type)) {
                    col.put("type", "Date");
                    imports.add("java.util.Date");
                }
                if ("datetime".equalsIgnoreCase(type)) {
                    col.put("type", "Date");
                    imports.add("java.util.Date");
                }
                if ("tinyint".equalsIgnoreCase(type)) {
                    col.put("type", "Integer");
                }
                if (type.toLowerCase().contains("decimal")) {
                    col.put("type", "BigDecimal");
                    col.put("defaultValue", "new BigDecimal(\"" + aDefault + "\")");
                    imports.add("java.math.BigDecimal");
                }
                col.put("isDefault", aDefault != null);
                col.put("name", StrKit.toCamelCase(field, false));
                col.put("alias", field);
                columnMetas.add(col);
                
            }
            model.put("imports", imports);
            model.put("columnMetas", columnMetas);
            Engine engine = Engine.use();
            engine.setToClassPathSourceFactory();
            Template template = engine.getTemplate("model.jf");
            template.render(model, new File(StrKit.firstCharToUpperCase(model.get("baseModelName").toString()) + ".java"));
        }
        
        
    }
}
