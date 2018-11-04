package com.grayliu.marriage.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

    //ID
    Integer id;
    //NO
    Integer num;
    //姓名
    String name;
    //昵称
    String nick;
    //婚姻状态
    String married;
    //联系电话
    String telephone;
    //民族
    String nation;
    //生日
    String birthday;
    //籍贯
    String from;
    //是否京籍
    String fromBJ;
    //身高
    String heigh;
    //体重
    String weight;
    //信仰
    String faith;
    //职务
    String duty;
    //是否独生子女
    String onlyChild;
    //毕业院校
    String academia;
    //学历学位
    String education;
    //房
    String house;
    //在京住址
    String addr;
    //车
    String car;
    //京车
    String carBJ;
    //单位
    String company;
    //薪资
    String salary;
    //爱好
    String interest;
    //优点
    String advantage;
    //家庭
    String family;
    //微信号
    String weixin;
    //择偶标准
    String require;


}
