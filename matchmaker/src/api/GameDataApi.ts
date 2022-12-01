import axios from "axios";
import { request } from "http";
import { Game } from "../models/Game";
import { GameRequest } from "../models/GameRequest";
import { GameResponse } from "../models/GameResponse";

export class GameDataApi {
  static getGame = async () =>
    await axios.get<Game[]>("http://localhost:8080/games");

  static postGame = async (request: GameRequest) =>
    await axios.post<GameResponse>("http://localhost:8080/games/addGame", request);

  static putGame = async (request: GameRequest) =>
    await axios.put<GameResponse>("http://localhost:8080/games/editGame", request);

  static deleteGame = async (request: GameRequest) =>
  await axios.delete<GameResponse>("http://localhost:8080/games/deleteGame");
}
