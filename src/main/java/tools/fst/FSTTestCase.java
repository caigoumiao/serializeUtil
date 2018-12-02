package tools.fst;

import org.junit.Test;
import org.nustaq.serialization.FSTConfiguration;
import testModel.User;

public class FSTTestCase
{
    static User u=new User("miaoqiao", 21, true, "nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao");

    @Test
    public void testFst(){
        long startTime= System.currentTimeMillis();
        byte[] tmp = FstUtil.serialize(u);
        long endTime=System.currentTimeMillis();
        System.out.println("序列化耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
        startTime= System.currentTimeMillis();
        User u1= (User) FstUtil.deserialize(tmp);
        endTime=System.currentTimeMillis();
        System.out.println("反序列化耗时："+ (endTime-startTime)+"ms");
    }

    @Test
    public void testFstUnsafe(){
        FSTConfiguration fstConfiguration=FSTConfiguration.createUnsafeBinaryConfiguration();
        long startTime= System.currentTimeMillis();
        byte[] tmp = fstConfiguration.asByteArray(u);
        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
    }

    @Test
    public void testFstJsonNoRef(){
        FSTConfiguration fstConfiguration=FSTConfiguration.createJsonNoRefConfiguration();
        long startTime= System.currentTimeMillis();
        byte[] tmp = fstConfiguration.asByteArray(u);
        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
    }

    @Test
    public void testFstMini(){
        FSTConfiguration fstConfiguration=FSTConfiguration.createMinBinConfiguration();
        long startTime= System.currentTimeMillis();
        byte[] tmp = fstConfiguration.asByteArray(u);
        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
    }
}
