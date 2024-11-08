document.addEventListener('DOMContentLoaded', function () {
    const links = document.querySelectorAll('.nav-link');
    const sections = document.querySelectorAll('.section');
    
    links.forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault(); // Prevent default anchor behavior
            const targetId = this.getAttribute('href'); // Get target section ID
            
            // Fade out current section and show blurred background
            sections.forEach(section => {
                if (section.classList.contains('active')) {
                    section.classList.remove('active'); // Remove active class
                    section.style.opacity = '0'; // Start fading out
                }
            });
            
            // Show blurred background
            const blurredBackground = document.createElement('div');
            blurredBackground.className = 'blurred-background';
            document.body.appendChild(blurredBackground);
            
            // Fade in new section
            const targetSection = document.querySelector(targetId);
            setTimeout(() => {
                targetSection.style.display = 'block'; // Show new section
                targetSection.classList.add('active'); // Add active class to fade in
                targetSection.style.opacity = '1'; // Start fading in
                
                // Remove blurred background after transition
                setTimeout(() => {
                    document.body.removeChild(blurredBackground);
                }, 500); // Match this duration with CSS transition time
            }, 500); // Wait for fade out before showing new section
        });
    });
});