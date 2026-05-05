# java-bugfix-assignment
Java bug-fixing assignment covering concurrency, exception handling, and maintenance tasks.

#Problem-Solving Approach
Analyzed issues from a production support perspective
Focused on root cause identification rather than symptom fixes
Applied minimal, low-risk changes to avoid regression
Ensured code stability under edge cases and concurrency

# Key Fixes & Insights
✅ Null Safety & Data Integrity (Task 1)
Eliminated NullPointerException scenarios
Handled edge cases like null inputs and missing dates
Ensured correct filtering logic for financial data
⚠️ ConcurrentModificationException (Task 2)
Identified unsafe collection modification during iteration
Applied iterator-based removal strategy
Ensured fail-safe behavior under concurrent access patterns
🔄 Concurrency Issue – Race Condition (Task 3)
Diagnosed lost updates due to non-atomic operations
Implemented thread-safe counter using AtomicInteger
Ensured accurate processing metrics in multi-threaded execution
🔌 Resource Leak – DB Connections (Task 4)
Identified unclosed JDBC resources causing pool exhaustion
Implemented try-with-resources for deterministic cleanup
Prevented long-running system degradation
📉 Logging & Exception Handling (Task 5)
Reduced log noise by separating expected vs unexpected errors
Replaced printStackTrace with structured logging (SLF4J)
Prevented silent failures and improved observability
