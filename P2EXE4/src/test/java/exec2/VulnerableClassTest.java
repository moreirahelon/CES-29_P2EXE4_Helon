package exec2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.SequenceInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import exe2.VulnerableClass;

public class VulnerableClassTest {
  private VulnerableClass _VulnerableClassTest = new VulnerableClass();

  @Test(expected = Exception.class)
  public void stringOfFilenameTest() throws Exception {
    _VulnerableClassTest.vulnerableMethod("./boot/virus");
    _VulnerableClassTest.vulnerableMethod("./*(&)");
  }

  @Test(expected = Exception.class)
  public void CaractereDeOperacaoTest() throws Exception {
    InputStream CaractereDeOperacao1 = new ByteArrayInputStream("/\n".getBytes());
    InputStream CaractereDeOperacao2 = new ByteArrayInputStream("R\n".getBytes());
    InputStream CaractereDeOperacao3 = new ByteArrayInputStream("W\n".getBytes());
    
    System.setIn(new SequenceInputStream(new SequenceInputStream(CaractereDeOperacao1, CaractereDeOperacao2), CaractereDeOperacao3));
    _VulnerableClassTest.vulnerableMethod("Test.txt");
  }
}
