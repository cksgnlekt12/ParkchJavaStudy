package Step3.g_Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

//외부적으로 클래스를 관리할 때는 Externalizable 인터페이스 선언
public class ExPerson implements Externalizable {

    String name;
    String job;

    public ExPerson() {}

    public ExPerson(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString()
    {
        return name + "," + job;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        //out.writeUTF(job);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        //job = in.readUTF();
    }

}
