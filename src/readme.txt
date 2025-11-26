# Java Exercises Project

## Exercise 1 – Todo List

Console-based task management application:

* Add, update, delete tasks
* Mark tasks as DONE
* Search tasks by title or description
* List all tasks
* List tasks sorted by status (NEW → IN_PROGRESS → DONE)

**Files:**

* `Task.java`, `Status.java`, `TaskRepository.java`, `TaskService.java`, `Main.java`, `tasks.json`

**How to Run:**

1. IDE: compile and run `Main.java`
2. Command line: `javac *.java` → `java Main`

---

## Exercise 2 – Strictly Increasing Subarrays

Function that receives an array of numbers and returns all **strictly increasing subarrays**.

**Example:**

* Input: `[1, 2, 3, 1, 2]`
* Output: `[1,2,3]`, `[1,2]`

**File:** `StrictMagnification.java`

---

## Exercise 3 – Design (Library + Orders/Payments)

### Library REST API

* **Endpoints:**

  * `Books`, `Authors`, `Users`, `Loans`
* **Operations:** GET, POST, PUT, DELETE
* **DTOs & required fields:**

  * `BookDTO` → title, authorId, available
  * `AuthorDTO` → name
  * `UserDTO` → name, email
  * `LoanDTO` → bookId, userId, loanDate

### Orders and Payments Classes

* **Order** → order details, status, total amount
* **Payment** → payment details, linked to order
* **Customer** → customer info and list of orders/payments
* **Product** → product details and price
* **OrderManager** → manage orders, calculate total, validate payment

**Payment validation:**

1. Check that `payment.orderId` exists in Orders
2. Verify that payment amount matches order total
3. Update order status after successful payment
