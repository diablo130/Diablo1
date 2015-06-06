package com.Diablo.JDBC;

/**
 * Created by 黄粟 on 2015/5/23.
 * 实例网址：
 * http://www.cnblogs.com/xdp-gacl/p/4007225.html
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;
/*import org.junit.Test;*/

public class QueryRunnerCRUDTest {
    public static void main(String[] args) throws  Exception {
        System.out.println("中文飒飒的");
        /*String username = "jy0188362@163.com";
        String password = "123123";
        /*System.out.println(username+"......"+password);
        QueryRunner qr = new QueryRunner();
        Connection conn = null;
        conn = DbUtiles.getConnection();
        String sql = "SELECT * from information.用户注册表 WHERE password='"+ password +"'";

        List list = (List) qr.query(conn,sql, new BeanListHandler(UserInfo.class));
        UserInfo ui = (UserInfo) list.get(0);
        System.out.println(ui.getUsername());*/
        /*try {
            List ResultList=(List)qr.query(conn, sql, new BeanListHandler<UserInfo>(UserInfo.class));
            System.out.print(ResultList);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

           /*List al = null;
            try {
                al = (List)qr.query(conn,"select * from 公交数据表", new BeanListHandler<BusInfo>(BusInfo.class));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Iterator ite = al.iterator();
            while(ite.hasNext()) {
                BusInfo bi = (BusInfo)ite.next();
                System.out.print(bi.get日期() + "|" + bi.get到站人数() + "|" + bi.get图() + "|" + bi.get节());
                System.out.println();
            }*/
    }

    /*
     *测试表
     create table users(
         id int primary key auto_increment,
         name varchar(40),
         password varchar(40),
         email varchar(60),
         birthday date
     );
     */

    /*@Test
    public void add() throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
        Object params[] = {"孤傲苍狼","123", "gacl@sina.com", new Date()};
        //Object params[] = {"白虎神皇","123", "gacl@sina.com", "1988-05-07"};
        qr.update(sql, params);
    }

    @Test
    public void delete() throws SQLException {

        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "delete from users where id=?";
        qr.update(sql, 1);

    }

    @Test
    public void update() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "update users set name=? where id=?";
        Object params[] = { "ddd", 5};
        qr.update(sql, params);
    }

    @Test
    public void find() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users where id=?";
        Object params[] = {2};
        User user = (User) qr.query(sql, params, new BeanHandler(User.class));
        System.out.println(user.getBirthday());
    }

    @Test
    public void getAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users";
        List list = (List) qr.query(sql, new BeanListHandler(User.class));
        System.out.println(list.size());
    }

    *//**
     * @Method: testBatch
     * @Description:批处理
     * @Anthor:孤傲苍狼
     *
     * @throws java.sql.SQLException
     *//*
    @Test
    public void testBatch() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
        Object params[][] = new Object[10][];
        for (int i = 0; i < 10; i++) {
            params[i] = new Object[] { "aa" + i, "123", "aa@sina.com",
                    new Date() };
        }
        qr.batch(sql, params);
    }

    //用dbutils完成大数据（不建议用）
    *//***************************************************************************
     create table testclob
     (
     id int primary key auto_increment,
     resume text
     );
     **************************************************************************//*
    @Test
    public void testclob() throws SQLException, IOException{
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into testclob(resume) values(?)";  //clob
        //这种方式获取的路径，其中的空格会被使用“%20”代替
        String path  = QueryRunnerCRUDTest.class.getClassLoader().getResource("data.txt").getPath();
        //将“%20”替换回空格
        path = path.replaceAll("%20", " ");
        FileReader in = new FileReader(path);
        char[] buffer = new char[(int) new File(path).length()];
        in.read(buffer);
        SerialClob clob = new SerialClob(buffer);
        Object params[] = {clob};
        runner.update(sql, params);
    }*/






    /**
     * @ClassName: ResultSetHandlerTest
     * @Description:测试dbutils各种类型的处理器
     * @author: 孤傲苍狼
     * @date: 2014-10-6 上午8:39:14
     *
     */


        /*@Test
        public void testArrayHandler() throws SQLException{
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from users";
            Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
            System.out.println(Arrays.asList(result));  //list  toString()
        }

        @Test
        public void testArrayListHandler() throws SQLException{

            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from users";
            List<Object[]> list = (List) qr.query(sql, new ArrayListHandler());
            for(Object[] o : list){
                System.out.println(Arrays.asList(o));
            }
        }

        @Test
        public void testColumnListHandler() throws SQLException{
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from users";
            List list = (List) qr.query(sql, new ColumnListHandler("id"));
            System.out.println(list);
        }

        @Test
        public void testKeyedHandler() throws Exception{
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from users";

            Map<Integer,Map> map = (Map) qr.query(sql, new KeyedHandler("id"));
            for(Map.Entry<Integer, Map> me : map.entrySet()){
                int  id = me.getKey();
                Map<String,Object> innermap = me.getValue();
                for(Map.Entry<String, Object> innerme : innermap.entrySet()){
                    String columnName = innerme.getKey();
                    Object value = innerme.getValue();
                    System.out.println(columnName + "=" + value);
                }
                System.out.println("----------------");
            }
        }

        @Test
        public void testMapHandler() throws SQLException{

            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from users";

            Map<String,Object> map = (Map) qr.query(sql, new MapHandler());
            for(Map.Entry<String, Object> me : map.entrySet())
            {
                System.out.println(me.getKey() + "=" + me.getValue());
            }
        }


        @Test
        public void testMapListHandler() throws SQLException{
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from users";
            List<Map> list = (List) qr.query(sql, new MapListHandler());
            for(Map<String,Object> map :list){
                for(Map.Entry<String, Object> me : map.entrySet())
                {
                    System.out.println(me.getKey() + "=" + me.getValue());
                }
            }
        }

        @Test
        public void testScalarHandler() throws SQLException{
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from users";  //[13]  list[13]
            int count = ((Long)qr.query(sql, new ScalarHandler(1))).intValue();
            System.out.println(count);
        }*/

}
