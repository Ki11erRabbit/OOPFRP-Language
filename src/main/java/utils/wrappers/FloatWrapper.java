package utils.wrappers;

import utils.IObject;
import utils.Message;

public class FloatWrapper implements IObject {
    double data;


    public FloatWrapper(double data) {
        this.data = data;
    }

    @Override
    public Message handleMessage(Message message) {
        return null;
    }
}
