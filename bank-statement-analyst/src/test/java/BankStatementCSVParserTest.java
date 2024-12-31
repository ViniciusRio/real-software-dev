import org.drs.model.BankTransaction;
import org.drs.service.BankStatementCSVParser;
import org.drs.service.BankStatementParser;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    private final BankStatementParser parser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = parser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(
                LocalDate.of(2017, Month.JANUARY, 30),
                -50, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.date(), result.date());
        Assert.assertEquals(expected.amount(), result.amount(), tolerance);
        Assert.assertEquals(expected.description(), result.description());
    }

    @Test
    public void shouldNotParseWithNumericInvalid() {
        final String line = "29-02-2018,not-a-number,Tesco";

        Assert.assertThrows(IllegalArgumentException.class, () -> parser.parseFrom(line));
    }

    @Test
    public void shouldNotParseWithInvalidDate() {
        final String line = "notvaliddate,-50,Tesco";
        Assert.assertThrows(IllegalArgumentException.class, () -> parser.parseFrom(line));
    }

    @Test
    public void shouldNotParseWithLineLengthWrong() {
        final String line = "30-01-2017,-50";
        Assert.assertThrows(IllegalArgumentException.class, () -> parser.parseFrom(line));
    }
}