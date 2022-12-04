import axios from "axios";
import {GameResponse } from "../models/GameResponse";

export class GameDataApi {
  static getGames = async () =>
    await axios.get<GameResponse[]>("http://localhost:9000/games");
}