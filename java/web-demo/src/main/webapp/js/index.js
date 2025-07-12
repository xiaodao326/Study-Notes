let next = document.querySelector('.next')
let prev = document.querySelector('.prev')
let slider = document.querySelector('.slider')
next.addEventListener("click", function () {
  let box = document.querySelectorAll('.box')
  slider.appendChild(box[0])
})
prev.addEventListener("click", function () {
  let box = document.querySelectorAll('.box')
  slider.prepend(box[box.length - 1])
})
