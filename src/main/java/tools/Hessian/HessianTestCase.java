package tools.Hessian;

import org.junit.Test;
import testModel.User;

import java.io.IOException;

public class HessianTestCase
{
    static User u=new User("miaoqiao", 21, true, "nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao");

    @Test
    public void testHessian() throws IOException
    {
        long startTime= System.currentTimeMillis();
        byte[] tmp = HessianUtil.serialize(u);
        long endTime=System.currentTimeMillis();
        System.out.println("序列化耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
        startTime= System.currentTimeMillis();
        User u1= (User) HessianUtil.deserialize(tmp, User.class);
        endTime=System.currentTimeMillis();
        System.out.println("反序列化耗时："+ (endTime-startTime)+"ms");
    }
}
