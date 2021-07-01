package com.gh;

import com.gh.dao.UserDao;
import com.gh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 方启豪
 */
public class TestUser {

    private SqlSessionFactory factory = null;

    @Before
    public void init() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void test() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<User> userAndScore = null;
        try {
            userAndScore = dao.findUserAndScore();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userAndScore);

    }

    @Test
    public void test1() throws Exception {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        List<User> list1 = dao.findUserIn(list);
        System.out.println(list1);
    }

    @Test
    public void test2() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        try {
            List<User> list1 = dao.findUserLimit(list);
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(6);
        try {
            List<User> list1 = dao.findUserBetween(list);
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findUserByNameAndSex() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        try {
            List<User> list = dao.findUserByNameAndSex(user);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setName("张三");
        try {
            List<User> list = dao.findUserByNameAndId(user);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        SqlSession session = factory.openSession();
        SqlSession session1 = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        UserDao dao1 = session1.getMapper(UserDao.class);
        List<User> list = dao.findById(1);
        System.out.println(list);
        session.close();
        System.out.println("------------");
        List<User> list1 = dao1.findById(1);
        System.out.println(list1);
    }

    @Test
    public void test6() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.deleteById(9);
        session.commit();
    }

    @Test
    public void test7() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user = new User();
        user.setName("汤鹏程");
        user.setSex("男");
        user.setAddress("华夏学院");
        user.setAge(22);
        dao.insertInfo(user);
        session.commit();
    }

    @Test
    public void test8() {
        SqlSession session = factory.openSession();
        SqlSession session1 = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        UserDao dao1 = session1.getMapper(UserDao.class);
        List<User> list = dao.findById(1);
        System.out.println(list);
        System.out.println("------------");
        session.close();
        List<User> list1 = dao1.findById(1);
        System.out.println(list1);
    }

}
