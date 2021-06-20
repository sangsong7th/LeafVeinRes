package connect.entity;

import connect.annotation.NettyEntity;

@NettyEntity({})
public class Test {
    private String name;
    private String code;

    public Test() {
    }

    public Test(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
