import './App.css'
import { Card } from '../components/todo/todo_card'
import { useTodoData } from '../hooks/useTodoData';

function App() {
  const { data, isLoading, error } = useTodoData();

  if (isLoading) return <div className="container"><h1>Todo List</h1><p>Loading...</p></div>;
  if (error) return <div className="container"><h1>Todo List</h1><p>Error loading todos.</p></div>;

  return (
    <div className="container">
      <h1>Todo List</h1>
      <div className="card-grid">
        {data?.map(todoData => (
          <Card
            key={todoData.id}
            id={todoData.id}
            title={todoData.title}
            description={todoData.description}
            priority={todoData.priority}
            status={todoData.status}
          />
        ))}
      </div>
    </div>
  )
}

export default App
