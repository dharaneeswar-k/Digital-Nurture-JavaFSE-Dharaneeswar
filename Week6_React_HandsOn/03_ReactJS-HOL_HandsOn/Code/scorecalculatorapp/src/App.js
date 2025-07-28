import React from 'react'
import CalculateScore from './components/CalculateScore'

const App = () => {
  return (
    <div>
    <CalculateScore Name={"Steeve"}
    School={"DNV Public School"}
    total={284}
    goal={3}/>
    </div>
  )
}

export default App