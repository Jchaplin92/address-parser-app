package chaplin;

import org.junit.jupiter.api.Test;

import static chaplin.AddressParser.parse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddressParserTest {

    private String addrATTNline = "ATTN: Guy Dawson";
    private String addrFAOline = "FAO: Guy Dawson";
    private String addrLowercaseATTNline = "attn: Guy Dawson";
    private String addrLowercaseFAOline = "fao: Guy Dawson";
    private String addressLine2 = "Crossflight Limited";
    private String addressLine3 = "Crossflight House";
    private String addressLine4 = "Skyway 14";
    private String addressLine5 = "Colnbrook";
    private String postcodeLine = "SL3 0BQ";
    private String countryLine = "United Kingdom";
    private String expectedRestOfAddress = String.format("%s%n%s%n%s%n%s%n%s%n%s",
            addressLine2,
            addressLine3,
            addressLine4,
            addressLine5,
            postcodeLine,
            countryLine);

    private String expectedATTNAddress = String.format("%s%n%s",
            addrATTNline,
            expectedRestOfAddress);
    private String expectedLowercaseATTNAddress = String.format("%s%n%s",
            addrLowercaseATTNline,
            expectedRestOfAddress);
    private String expectedFAOAddress = String.format("%s%n%s",
            addrFAOline,
            expectedRestOfAddress);
    private String expectedLowercaseFAOAddress = String.format("%s%n%s",
            addrLowercaseFAOline,
            expectedRestOfAddress);

    @Test
    public void withSingleStringInputMovesATTNAbbreviationToTopOfAddress() {
        String inputAddress = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s",
                addressLine2,
                addrATTNline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine);

        assertThat(parse(inputAddress), equalTo(expectedATTNAddress));
    }

    @Test
    public void withSingleStringInputMovesLowercaseATTNAbbreviationToTopOfAddress() {
        String inputAddress = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s",
                addressLine2,
                addrLowercaseATTNline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine);

        assertThat(parse(inputAddress), equalTo(expectedLowercaseATTNAddress));
    }

    @Test
    public void withSingleStringInputMovesFAOAbbreviationToTopOfAddress() {
        String inputAddress = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s",
                addressLine2,
                addrFAOline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine);

        assertThat(parse(inputAddress), equalTo(expectedFAOAddress));
    }

    @Test
    public void withSingleStringInputMovesLowercaseFAOAbbreviationToTopOfAddress() {
        String inputAddress = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s",
                addressLine2,
                addrLowercaseFAOline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine);

        assertThat(parse(inputAddress), equalTo(expectedLowercaseFAOAddress));
    }
    @Test
    public void withStringArrayInputMovesATTNAbbreviationToTopOfAddress() {
        assertThat(parse(addressLine2,
                addrATTNline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine), equalTo(expectedATTNAddress));
    }

    @Test
    public void withStringArrayInputMovesLowercaseATTNAbbreviationToTopOfAddress() {
        assertThat(parse(addressLine2,
                addrLowercaseATTNline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine), equalTo(expectedLowercaseATTNAddress));
    }

    @Test
    public void withStringArrayInputMovesFAOAbbreviationToTopOfAddress() {
        assertThat(parse(addressLine2,
                addrFAOline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine), equalTo(expectedFAOAddress));
    }

    @Test
    public void withStringArrayInputMovesLowercaseFAOAbbreviationToTopOfAddress() {
        assertThat(parse(addressLine2,
                addrLowercaseFAOline,
                addressLine3,
                addressLine4,
                addressLine5,
                postcodeLine,
                countryLine), equalTo(expectedLowercaseFAOAddress));
    }
}

