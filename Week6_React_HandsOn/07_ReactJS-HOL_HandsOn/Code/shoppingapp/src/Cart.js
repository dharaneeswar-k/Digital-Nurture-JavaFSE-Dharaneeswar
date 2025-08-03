import React from 'react';

const Cart = ({ item }) => {
  return (
    <div className='table-container'>
      <table border="1" >
        <thead>
          <tr>
            <th style={{ fontWeight: 'bold' }}>Name</th>
            <th style={{ fontWeight: 'bold' }}>Price</th>
          </tr>
        </thead>
        <tbody>
          {item.map((product, index) => (
            <tr key={index}>
              <td>{product.itemname}</td>
              <td>{product.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Cart;
