# Task 2 — ConcurrentModificationException Analysis

## 1. Cause
Occurs when a collection is modified while iterating over it.

## 2. Likely Code Pattern
for (Transaction t : transactions) {
    if (condition) {
        transactions.remove(t);
    }
}

## 3. Minimal Fix
Iterator<Transaction> it = transactions.iterator();
while (it.hasNext()) {
    Transaction t = it.next();
    if (condition) {
        it.remove();
    }
}
