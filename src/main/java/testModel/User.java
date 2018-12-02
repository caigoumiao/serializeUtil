package testModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable
{
    private String name;
    private int age;
    private boolean isUgly;
    private String t_1;
    private String t_2;
    private String t_3;
    private String t_4;
    private String t_5;
    private String t_6;
    private String t_7;
    private String t_8;
    private String t_9;
}
