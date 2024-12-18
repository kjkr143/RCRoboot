# RC Robots Navigation System

## Problem Statement
ACME Co. operates a squad of Remote-Controlled (RC) Robots in a rectangular warehouse. The robots are tasked with navigating the warehouse grid to gather complete camera footage of their surroundings. This program enables control over the robots' movements and determines their final positions and orientations based on a series of instructions.

## Features
- Simulates navigation of robots in a rectangular grid.
- Processes movement commands: `L` (Left), `R` (Right), and `M` (Move Forward).
- Ensures robots follow cardinal directions (N, E, S, W).
- Prevents robots from exceeding the warehouse boundaries.

## Input Format
1. The first line specifies the upper-right coordinates of the warehouse grid. The bottom-left corner is always assumed to be `(0, 0)`.
2. For each robot:
   - The first line specifies the robot's initial position and orientation (e.g., `x y D` where `D` is one of `N`, `E`, `S`, `W`).
   - The second line specifies the movement commands (e.g., `LRMMRL`).

### Example Input:
```plaintext
5 5
1 0 N
MMRMMLMMR
3 2 E
MLLMMRMM
```

## Output Format
For each robot, the program outputs its final position and orientation after processing all commands.

### Example Output:
```plaintext
2 3 N
4 0 W
```

## Edge Cases
- Commands that would move a robot beyond the warehouse boundaries are ignored.
- Invalid commands (anything other than `L`, `R`, `M`) are skipped.
- Lowercase commands (`l`, `r`, `m`) are handled by converting them to uppercase.

## How It Works
1. **Initialization**:
   - Parse the warehouse dimensions and robot details from the input.
2. **Processing Commands**:
   - For each robot, execute the commands sequentially:
     - `L`: Rotate 90 degrees left.
     - `R`: Rotate 90 degrees right.
     - `M`: Move one step forward in the current direction (if within bounds).
3. **Output Results**:
   - After processing all commands for a robot, print its final position and orientation.

## Code Highlights
- **Boundary Checks**:
  Ensure robots do not move outside the defined grid.
- **Direction Handling**:
  Update orientation based on `L` or `R` commands.
- **Case-Insensitive Commands**:
  Convert all commands to uppercase for uniform processing.

## Assumptions
- The warehouse is a rectangular grid.
- Robots move sequentially and independently.
- The grid coordinates are non-negative integers.
- Robots do not interact with or block each other.

## Usage
### Input Method
- Provide the input via standard input (console) or a file.

### Example Execution:
1. Compile the program:
   ```bash
   javac RCRobot.java
   ```
2. Run the program:
   ```bash
   java RCRobot
   ```
3. Enter input directly or from a file:
   ```plaintext
   5 5
   1 0 N
   MMRMMLMMR
   3 2 E
   MLLMMRMM
   ```

### Output:
```plaintext
2 3 N
4 0 W
```

