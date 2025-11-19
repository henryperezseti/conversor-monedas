import java.time.LocalDateTime;

public record ConversionHistory(
        String base,
        String target,
        double amount,
        double result,
        double rate,
        LocalDateTime timestamp
) {}
