package test;

import com.nrj.tank.ResourceMgr;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest{

    @Test
    void test() {

        try {
            BufferedImage image = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("Images/" + 1 + ".gif"));
            assertNotNull(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}