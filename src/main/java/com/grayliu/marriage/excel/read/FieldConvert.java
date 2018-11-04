package com.grayliu.marriage.excel.read;

public class FieldConvert {

    public static String getField(String name){

        switch(name){
            case "序号": return "num";
            case "姓名": return "name";
            case "群昵称": return "nick";
            case "联系方式": return "telephone";
            case "联系电话": return "telephone";
            case "婚否": return "married";
            case "婚姻状况": return "married";
            case "籍贯": return "from";
            case "是否京户":return "fromBJ";
            case "民族": return "nation";
            case "出生年月": return "birthday";
            case "身高": return "height";
            case "体重": return "weight";
            case "是否独生子女": return "onlyChild";
            case "毕业院校": return "academia";
            case "学历学位": return "education";
            case "是否有房、车": return "house";
            case "是否京房": return "houseBJ";
            case "是否有京车": return "carBJ";
            case "户口所在地": return "addr";
            case "北京住址区域": return "addr";
            case "工作单位": return "company";
            case "薪资": return "salary";
            case "爱好": return "interest";
            case "家庭情况": return "family";
            case "父母姊妹情况": return "family";
            case "联系微信": return "weixin";
            case "微信号": return "weixin";
            case "微信": return "weixin";
            case "择偶标准": return "require";
            case "对对方的要求": return "require";
            case "发布人": return "name";
            case "信仰": return "faith";
            case "职务": return "duty";
            case "职务（党员）": return "duty";
            case "收入": return "salary";
            case "优点": return "advantage";
            case "优点、性格": return "advantage";
            default: return null;
        }

    }



}
