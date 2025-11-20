import './App.css'
import { Card } from '../components/todo/todo_card'
import { useTodoData } from '../hooks/useTodoData';

function App() {
  const { data } =  useTodoData();

  return (
    <div className="container">
      <h1>Todo List</h1>
      <div className="card-grid">
        {data?.map(todoData => 
        <Card 
          title={todoData.title} 
          description={todoData.description} 
          todoPriority={todoData.todoPriority} 
          todoStatus={todoData.todoStatus}
        />)}
      </div>
    </div>
  )
}

export default App
