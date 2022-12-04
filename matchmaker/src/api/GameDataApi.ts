import axios from "axios";
import { Game } from "../models/game/Game";


export class GameDataApi {

    static getGame = async () =>
    await axios.get<Game[]>("http://localhost:9000/games");

  static postGame = async (request: Game) =>
    await axios.post<Game>("http://localhost:9000/games/addGame", request);
  static putGame = async (request: Game) =>
    await axios.put<Game>("http://localhost:9000/games/editGame", request);
  static deleteGame = async (id: number) =>
  await axios.delete<Game>("http://localhost:9000/games/deleteGame", {params: {id: id}});
  

}
