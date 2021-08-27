package net;


import com.player.framework.util.ByteBuffUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class clientTest {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 6080);
            OutputStream oos = s.getOutputStream();

            ByteBuf out = Unpooled.buffer();
            out.writeShort(101);

            out.writeByte(1);
            out.writeShort(2);
            out.writeInt(3);
            ByteBuffUtil.writeByteString(out, "abcdefghijklmnopqrstyvwxyz中文测试0123456789,./[]'*-+");
            ByteBuffUtil.writeShortString(out, "abcdefghijklmnopqrstyvwxyz中文测试0123456789,./[]'*-+");

            out.writeByte(4);
            out.writeShort(5);
            out.writeInt(6);
            ByteBuffUtil.writeByteString(out, "abcdefghijklmnopqrstyvwxyz中文测试0123456789,./[]'*-+");

            int x = 2;
            out.writeShort(x);
            for (int i = 0; i < x; i++) {
                out.writeByte(i + 1);
                out.writeShort(i + 1);
                out.writeInt(i + 1);
                ByteBuffUtil.writeByteString(out, "abcdefghijklmnopqrstyvwxyz中文测试0123456789,./[]'*-+");
            }

            oos.write(pack(out));
            oos.flush();
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static byte[] pack(ByteBuf b) {
        ByteBuf out = Unpooled.buffer();
        out.writeInt(0);
        out.writeInt(0);
        out.writeShort(b.readableBytes());
        out.writeBytes(b);
        byte[] bytes = new byte[out.readableBytes()];
        out.readBytes(bytes);
        return bytes;
    }


}
