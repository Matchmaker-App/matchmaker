import React from "react";
import "./styles.css";

const GameInput = () => {
  return (
    <form className="input">
      <input
        type="input"
        placeholder="Wprowadź nazwę gry:"
        className="input__box"
      />
      <button type="submit" className="input_submit">
        Ok
      </button>
    </form>
  );
};

export default GameInput;
