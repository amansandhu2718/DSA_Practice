# **Day 1**
### **1. Implement Stack using Array and ArrayList**
### **2. Reverse a String using Stack**
### **3. Valid Parenthesis**
### **4. Decode String  ( Leet Code #394 )**
### **5. Next greater element ( Leet Code #496 )**
### **6. Next Smaller Element**
### **7. Previous Greater Element**
### **8. Previous smaller Element**
### **9. Largest Rectangle Histogram ( Leetcode #84 )**
### **10.  Daily Temperature ( Leetcode #739 )**
---

# My Notes
## Types of problems in **stack **data structure
1. **Basics & mental model** — push/pop/peek, stack implementation, dry runs.
2. **Balanced / matching problems** — parentheses, decode string, path simplification.
3. **Monotonic stack** — next greater/smaller, daily temperatures, histogram intuition.
4. **Min/Max stack & variations** — min stack, stack with extra state.
5. **Two-stacks & nested states** — expression evaluation, undo, stack-of-stacks patterns, harder problems.
---

### 1. Basics & mental model
**Idea:** Stack = Last In, First Out (LIFO). Use it when you need to _remember recent things_ and pop them once they’re no longer needed.



### 2. Balanced / Matching (Basic stack pattern)
**Clue:** If the problem mentions parentheses, tags, or matching open/close — use a stack.

### Algorithm (valid parentheses)
- Traverse characters.
- If open bracket (`(` , `[` , `{` ) → push it.
- If close bracket → if stack empty or top not matching open → invalid. Else pop.
- At end, stack must be empty.
### Dry run: `s = "([{}])"`
- push '(' → ['(']
- push '[' → ['(', '[']
- push '{' → ['(', '[', '{']
- see '}' → top '{' matches → pop → ['(', '[']
- see ']' → pop → ['(']
- see ')' → pop → []
- result: valid


### 3. Monotonic Stack (the big unlock)
**Clue:** Problems asking _next/previous greater or smaller_, _span_, _temperatures_, _histogram_.

**Idea:** Maintain stack so the elements (or indices) follow a monotonic order. When a new element arrives, pop elements that violate monotonicity — those popped elements have their answer determined by the new element.

### Classic: Next Greater Element (to the right)
Goal: for each index i, find first index j>i with arr[j] > arr[i] (or -1 if none).

**Method (left→right using stack of indices for decreasing stack):**

- stack holds indices with decreasing values (so top has smallest recent among those).
- For current i, while stack non-empty and arr[i] > arr[stack[-1]]: popped index p gets next greater = arr[i].
- Push i.


### 4. Min/Max Stack
**Clue:** "Design a stack that returns min (or max) in O(1)".

**Idea:** Keep an auxiliary stack `min_stack` that tracks the minimum up to current level.



### 5. Two-stacks & Nested states (expressions, decode)
**Two-stacks for expressions:** one for operands (numbers), one for operators. Handle precedence and parentheses.

**Decode string example (**`**"3[a2[c]]"**`**):**

- Use stack to store previous string and repeat count when you hit `[` .
- Build current string until closing bracket, then pop repeat and previous string and combine.
### Quick decode algorithm sketch
- Iterate chars:
    - build number when digit
    - on '[': push (current_str, current_num); reset them
    - on letter: append to current_str
    - on ']': pop prev_str, num; current_str = prev_str + current_str * num

### Practice
- Evaluate Reverse Polish Notation (postfix eval)
- Basic Calculator (handle + - * / and parentheses)
- Decode String
---

# Study & thinking tips (how to recognize and not get stuck)
- Ask: “Do I ever need to _look back_ only at the most recent items?” → stack.
- When scanning an array and you need the _next_ element satisfying a property: think **monotonic stack**.
- Always dry-run with a small example and explicitly write stack states. That’s the fastest way to build intuition.
- When stuck on a problem, simulate with the stack and write why each push/pop happens.


