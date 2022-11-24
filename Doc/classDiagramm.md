# Projektseminar

```mermaid
classDiagram
    class Task{
        int difficulty
        int knotGrade
        int length
            Setter();Getter()
    }

    class generatorTask{
        string taskText
        generateTaskText()
        showTaskText()
    }
    
    class generatorSolution{
        string SolutionText
        string hintText
        generateSolution()
        generateHintText()
        compareSolution()
        showSolution()
        showHint()
    }
    
    class generatorEPK{
        int amountGates
        int amountEvents
        int amountFunctions
        generateEPK()
        showEPK()
        calcAmountGates()
        calcAmountEvents()
        calcAmountFunctions()
    }

generatorEPK o-- Task
generatorSolution o-- Task
generatorTask o-- Task
generatorEPK o-- generatorTask