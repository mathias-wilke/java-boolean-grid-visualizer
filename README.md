# Conway's Game of Life Visualizer

This project provides a simple Java application to visualize Conway's Game of Life, a cellular automaton devised by the British mathematician John Horton Conway in 1970. The application displays the evolution of a grid of cells, each of which can be alive or dead, based on a set of rules that simulate cellular automaton.

![Example1](java-boolean-grid-visualizer-example.png?raw=true)

## Features

- Visualizes Conway's Game of Life on a grid.
- Allows customization of the initial state of the grid with either random values or predefined patterns.
- Supports dynamic updating of the grid to show the evolution of the game over time.

## Getting Started

To get started with this project, clone the repository and open it in your favorite Java IDE. The project contains two main classes:

1. **BooleanGridVisualizer**: A class that sets up the visual framework for displaying the grid. It includes methods for initializing and drawing the grid based on the state of the cells.

2. **StartUp**: The entry point of the application. This class contains the `main` method, which initializes the grid and starts the game. It also includes placeholder methods for implementing the logic of Conway's Game of Life.

### Prerequisites

- Java Development Kit (JDK) 8 or higher.

### Running the Application

1. Compile and run the `StartUp` class.
2. The application will display a window showing the initial state of the grid.
3. The grid will automatically update based on the rules of Conway's Game of Life.

## Implementing Conway's Game of Life

Students are encouraged to implement the logic of Conway's Game of Life by filling in the placeholder methods provided in the `StartUp` class:

- `initializeGrid(int rows, int cols)`: Initializes the grid with a specific pattern or randomly.
- `updateGrid(boolean[][] grid)`: Updates the grid based on the game's rules.
- `countLivingNeighbors(boolean[][] grid, int row, int col)`: Counts the living neighbors around a specific cell.

## License

This project is open-source and available under the MIT License.
