import axios from "axios";
import { GameResponse } from "../models/GameResponse";
import { MeetGet } from "../models/MeetGet";


export class MeetApi {
  static getMeets = async () =>
    await axios.get<MeetGet[]>("http://localhost:9000/meet/");

static getMeetById = async () =>
    await axios.get<MeetGet[]>("http://localhost:9000/meet/");

    static getGameForMeets = async () =>
    await axios.get<GameResponse[]>("http://localhost:9000/games");
}
