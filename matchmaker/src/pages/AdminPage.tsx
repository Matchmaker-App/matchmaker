import {
  Button,
  FormControl,
  FormErrorMessage,
  FormLabel,
  Input,
  Textarea,
  useToast,
} from "@chakra-ui/react";
import React, { useCallback, useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { GameDataApi } from "../api/GameDataApi";
import { GameDataContext } from "../App";
import { Wrapper } from "../components/Wrapper";
import { Game } from "../models/game/Game";
import { GameResponse } from "../models/game/GameResponse";

interface GameData {
  name: string;
  isNameValid: boolean;
  genre: string;
  isGenreValid: boolean;
  platform: string;
  isPlatformValid: boolean;
  description: string;
  isDescriptionValid: boolean;
}

export const AdminPage = () => {
  const context = useContext(GameDataContext);
  const toast = useToast();
  const navigate = useNavigate();
  const [gameData, setGameData] = useState<GameData>({
    name: "",
    isNameValid: false,
    genre: "",
    isGenreValid: false,
    platform: "",
    isPlatformValid: false,
    description: "",
    isDescriptionValid: false,
  });

  const onNameChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGameData({ ...gameData, name: event.currentTarget.value });
  };
  const onGenreChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGameData({ ...gameData, genre: event.currentTarget.value });
  };
  const onPlatformChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGameData({ ...gameData, platform: event.currentTarget.value });
  };

  const onDescriptionChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGameData({ ...gameData, description: event.currentTarget.value });
  };

  const isNameValid = () => {
    if (!gameData.name) {
      return false;
    }
    return gameData.name.length <= 40;
  };
  const isGenreValid = () => {
    if (!gameData.genre) {
      return false;
    }
    return gameData.genre.length <= 30;
  };
  const isPlatformValid = () => {
    if (!gameData.platform) {
      return false;
    }
    return gameData.platform.length <= 15;
  };

  const isDescriptionValid = () => {
    if (!gameData.description) {
      return false;
    }
    return gameData.description.length <= 300;
  };

  const [requestGetGame, setRequestGetGame] = useState<Game[]>([]);

  const fetchGameData = useCallback(async () => {
    try {
      const usages = await GameDataApi.getGame();
      setRequestGetGame(usages.data);
    } catch (error) {
      console.error(error);
    }
  }, []);

  useEffect(() => {
    fetchGameData();
  }, []);

  const [postGameData, setGame] = useState<GameResponse>();
 

  const postGame = useCallback(async () => {
    const postGameResult = await GameDataApi.postGame({
      gameData: context.gameData,
    });

    setGame(postGameResult.data);

    postGameResult.data.game.forEach((game) => {
      
    });

  useEffect(() => {
    postGame();
  }, [postGame]);

  return (
    <Wrapper heading="Panel Administracyjny">
      <FormControl isInvalid={!!gameData.name && !isNameValid()}>
        <FormLabel>Dodaj Grę:</FormLabel>
        <Input type="text" value={gameData.name} onChange={onNameChanged} />
        <FormErrorMessage>Pole wymagane!</FormErrorMessage>
      </FormControl>

      {/* {!gameData.name&&<FormLabel>Dodaj Grę:</FormLabel>} */}

      <FormControl isInvalid={!!gameData.genre && !isGenreValid()}>
        <FormLabel>Dodaj Gatunek:</FormLabel>
        <Input type="text" value={gameData.genre} onChange={onGenreChanged} />
        <FormErrorMessage>Pole wymagane!</FormErrorMessage>
      </FormControl>

      <FormControl isInvalid={!!gameData.platform && !isPlatformValid()}>
        <FormLabel>Dodaj Platformę:</FormLabel>
        <Input
          type="text"
          value={gameData.platform}
          onChange={onPlatformChanged}
        />

        <FormErrorMessage>Pole wymagane!</FormErrorMessage>
      </FormControl>

      <FormControl isInvalid={!!gameData.description && !isDescriptionValid()}>
        <FormLabel>Dodaj Opis:</FormLabel>
        <Input
          type="textarea"
          value={gameData.description}
          onChange={onDescriptionChanged}
        />
        <Textarea placeholder="Opis..." />
        <FormErrorMessage>Pole wymagane!</FormErrorMessage>
      </FormControl>

      <Button
        colorScheme="blue"
        disabled={
          !isNameValid() ||
          !isGenreValid() ||
          !isPlatformValid() ||
          !isDescriptionValid()
        }
      >
        Zatwierdź
      </Button>
    </Wrapper>
  );
};
