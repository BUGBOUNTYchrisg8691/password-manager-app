import './App.css';
import { Switch, Route } from 'react-router-dom';
import SNav from './components/SNav';
import LoginForm from './components/LoginForm';
import PrivateRoute from './utils/PrivateRoute';
import Dashboard from './components/Dashboard';

function App() {
  return (
    <div className="App">
      <SNav />
      <Switch>
        <Route exact path="/" component={LoginForm} />
        <PrivateRoute path="/dashboard" component={Dashboard} />
      </Switch>
    </div>
  );
}

export default App;
