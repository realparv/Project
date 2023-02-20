const io = require('socket.io-client');
const readline=require('readline');

const socket = io('http://localhost:3006');

const rl=readline.createInterface( {
  input:process.stdin,
  output:process.stdout
});

rl.on('str',(input)=>{
  socket.emit('message',input);
});

socket.on('connect', () => {
  console.log('Connected to server');
  socket.emit(Hello);
});

socket.on('message', (data) => {
  console.log('Server:', data);
});

// socket.emit('message', 'Hello');
