import {
  Button,
  Center,
  FormControl,
  FormErrorMessage,
  FormLabel,
  Heading,
  Input,
  Stack,
} from "@chakra-ui/react";
import React, { useState } from "react";

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

  return (
    <Center h="100vh" flexDirection={"column"}>
      <Heading>Panel Administracyjny</Heading>
      <Stack direction={"column"} bg="white" p={16}>
        <FormControl isInvalid={!!gameData.name && !isNameValid()}>
          <FormLabel>Dodaj Grę:</FormLabel>
          <Input type="text" value={gameData.name} onChange={onNameChanged} />
          <FormErrorMessage>Pole wymagane!</FormErrorMessage>
        </FormControl>

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

        <FormControl
          isInvalid={!!gameData.description && !isDescriptionValid()}
        >
          <FormLabel>Dodaj Opis:</FormLabel>
          <Input
            type="text"
            value={gameData.description}
            onChange={onDescriptionChanged}
          />
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
      </Stack>
    </Center>
  );
};
