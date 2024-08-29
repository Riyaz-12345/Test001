let expenses=[34,54,67,45,78,67]
let totalExpense=expenses.reduce((sum,expenses)=>sum+expenses,0)
console.log(totalExpense)

var largest=expenses[0]
var smallest=expenses[0]
for(let i=0;i<=expenses.length;i++)
{
    if(expenses[i]>largest){
        largest=expenses[i]
    }
    
     if(expenses[i]<smallest)
    {
        smallest=expenses[i]
    }
}
console.log(largest)
console.log(smallest)

let students=[600,5978,867967,8578,96868]
students.unshift(56)
console.log(students)
students.pop()
console.log(students)
let price=[9686569,597668,78585,578569,585905]
console.log(price.map(price=>(price*.1)/100))