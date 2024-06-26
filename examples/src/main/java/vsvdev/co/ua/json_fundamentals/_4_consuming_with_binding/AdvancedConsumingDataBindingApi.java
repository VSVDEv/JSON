package vsvdev.co.ua.json_fundamentals._4_consuming_with_binding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdvancedConsumingDataBindingApi {
    private static final File BANK_LOAN_FILE = new File("src/main/resources/bank_loan.json");

    public static void main(String[] args) throws IOException {
        final LocalDateDeserializer localDateDeserializer =
                new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE);

        final SimpleModule module = new SimpleModule()
                .addDeserializer(LocalDate.class, localDateDeserializer);

        final ObjectMapper mapper = new ObjectMapper()
                .registerModule(module);

        final ImmutableLoanApplication loanApplication =
                mapper.readValue(BANK_LOAN_FILE, ImmutableLoanApplication.class);
        System.out.println(loanApplication + "\n\n");
    }
}
