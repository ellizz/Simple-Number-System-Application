<!-- Copilot/agent instructions for contributors -->
# Simple-Number-System-Application — Agent Guidance

This is a tiny, single-file Java CLI project. The goal of edits should be to keep changes small, obvious, and consistent with the original interactive UX.

- **Primary entry:** NumberSystemApplication.java (root). This is the only source file; read it top-to-bottom to understand behavior.
- **Big picture:** a console menu loop that reads user input via `Scanner`, parses an input number into a temporary decimal (`tempdeci`) using `Integer.parseInt(tempnum, radix)`, then formats outputs with `Integer.toString(tempdeci, radix)` (radices: 2, 8, 10, 16). Hex input is uppercased before parsing and hex output is uppercased.
- **Run / build (no tools):** compile and run with the system JDK:

  - `javac NumberSystemApplication.java`
  - `java NumberSystemApplication`

- **User-facing behavior to preserve:** menu strings, prompts, and the interactive control flow (options 1–5, yes/no prompts). The program expects menu choices as string digits (`"1"`..`"5"`) and uses `NumberFormatException` to detect invalid numeric input for conversions.
- **Common code patterns:**
  - Parsing user input: `Integer.parseInt(tempnum, <radix>)` (examples: radix 2 for binary, 8 for octal, 10 for decimal, 16 for hex).
  - Formatting outputs: `Integer.toString(tempdeci, <radix>)` followed by `toUpperCase()` for hex display.
  - Control flow: nested `while` loop + `switch` on `choice` strings.

- **Project conventions / found patterns:**
  - Keep CLI output formatting (ASCII separators) intact for UX consistency.
  - Minimal error handling: the app uses try/catch around `Integer.parseInt` and asks the user whether to continue.
  - No external libraries, no build system, no tests present.

- **If you change behavior or refactor:**
  - Document the reason in the commit message and update `README.md` if the user-visible behavior changes.
  - Prefer small, testable refactors: extract parsing/conversion into well-named `static` methods (e.g., `parseToDecimal(String s, int radix)` and `formatFromDecimal(int value, int radix)`) to enable unit testing later.

- **Integration points / dependencies:** none — the app uses only the JDK standard library.

- **When adding tests or CI:** extract logic out of `main` before adding test harnesses. There are no existing test files or CI configs to follow.

- **Commit guidance:** single-purpose commits, e.g. `chore: add copilot instructions` or `refactor: extract parse/format helpers`.

If any section is unclear or you want me to add a small refactor (e.g. extract conversion helpers and a JUnit test), tell me which direction you prefer and I will prepare the change.
