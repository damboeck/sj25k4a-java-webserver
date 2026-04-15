function init() {
    const canvas = document.getElementById('myCanvas');
    const c = canvas.getContext('2d');
    c.strokeStyle = 'magenta';
    c.moveTo(10, 10);
    c.lineTo(500, 300);
    c.stroke();
    drawCar(c,1,'red',300,300);
}

/** Zeichnet ein kleines Auto in einen Canvas Context */
function drawCar(c,size,color,posX,posY) {
    // defensiv: gültigen Context prüfen
    if (!c || typeof c.fillRect !== 'function') return;

    // Default-Parameter
    size = (typeof size === 'number' && isFinite(size)) ? size : 1;
    color = color || '#f60';
    posX = (typeof posX === 'number') ? posX : 0;
    posY = (typeof posY === 'number') ? posY : 0;

    // Basismaße (werden mit size skaliert)
    const w = 100 * size; // Gesamtbreite
    const h = 40 * size;  // Karosseriehöhe
    const wheelRadius = 12 * size;

    c.save();
    c.translate(posX, posY);
    c.lineJoin = 'round';

    // Karosserie (unterer Kasten)
    c.beginPath();
    c.fillStyle = color;
    c.strokeStyle = '#333';
    c.lineWidth = Math.max(1, 2 * size);
    c.rect(0, 0, w, h);
    c.fill();
    c.stroke();

    // Dach / Oberer Teil (als abgerundetes Dreieck/Trapez)
    c.beginPath();
    c.moveTo(w * 0.2, 0);
    c.lineTo(w * 0.35, -h * 0.7);
    c.lineTo(w * 0.65, -h * 0.7);
    c.lineTo(w * 0.8, 0);
    c.closePath();
    c.fillStyle = color;
    c.fill();
    c.stroke();

    // Fenster (hellere Farbe)
    c.beginPath();
    c.fillStyle = 'rgba(255,255,255,0.7)';
    c.moveTo(w * 0.37, -h * 0.55);
    c.lineTo(w * 0.52, -h * 0.55);
    c.lineTo(w * 0.52, -h * 0.2);
    c.lineTo(w * 0.37, -h * 0.2);
    c.closePath();
    c.fill();
    c.stroke();

    c.beginPath();
    c.fillStyle = 'rgba(255,255,255,0.7)';
    c.moveTo(w * 0.53, -h * 0.55);
    c.lineTo(w * 0.67, -h * 0.55);
    c.lineTo(w * 0.67, -h * 0.2);
    c.lineTo(w * 0.53, -h * 0.2);
    c.closePath();
    c.fill();
    c.stroke();

    // Räder
    const wheelY = h + wheelRadius * 0.2;
    const wheelX1 = w * 0.25;
    const wheelX2 = w * 0.75;

    // Hinterrad
    c.beginPath();
    c.fillStyle = '#111';
    c.arc(wheelX1, wheelY, wheelRadius, 0, Math.PI * 2);
    c.fill();
    // Felge
    c.beginPath();
    c.fillStyle = '#999';
    c.arc(wheelX1, wheelY, wheelRadius * 0.5, 0, Math.PI * 2);
    c.fill();

    // Vorderrad
    c.beginPath();
    c.fillStyle = '#111';
    c.arc(wheelX2, wheelY, wheelRadius, 0, Math.PI * 2);
    c.fill();
    // Felge
    c.beginPath();
    c.fillStyle = '#999';
    c.arc(wheelX2, wheelY, wheelRadius * 0.5, 0, Math.PI * 2);
    c.fill();

    c.restore();
}
