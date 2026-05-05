import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class Task5 {

    private static final Logger logger = LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                // FIX: specific exception
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                // FIX: avoid generic exception
                throw new IllegalArgumentException("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {
            // FIX: log expected errors without stack trace
            logger.warn("Validation failed: {}", e.getMessage());
            return new ValidationResult(false);

        } catch (Exception e) {
            // FIX: log unexpected errors
            logger.error("Unexpected error", e);
            throw e;
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX: null-safe check
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX: do not swallow exception
                logger.error("Batch processing error", e);
            }
        }
    }

    private ValidationResult runValidationRules(String content) { return null; }
    private void saveResult(ValidationResult r) {}
}
