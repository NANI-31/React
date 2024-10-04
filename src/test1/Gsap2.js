import React, { useEffect, useRef } from "react";
import { gsap } from "gsap";


const Gsap2 = () => {
    const boxRefs = useRef([]);
    useEffect(() => {
        gsap.to(boxRefs.current, 
            { scale: 0 },
            { scale: 5, duration: 4, stagger: 0.2 }
        )
    })
  return (
    <div>
      {Array(3)
        .fill()
        .map((_, i) => (
          <div
            key={i}
            ref={(el) => (boxRefs.current[i] = el)}
            style={{
              width: "100px",
              height: "100px",
              backgroundColor: "green",
              margin: "10px",
            }}
          />
        ))}
    </div>
  )
}

export default Gsap2
