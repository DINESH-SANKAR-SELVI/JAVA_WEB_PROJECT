let bar = document.querySelector('.bars'),
values = document.querySelector('.options');

bar.addEventListener('click', ()=> {
      values.classList.toggle('active');
})