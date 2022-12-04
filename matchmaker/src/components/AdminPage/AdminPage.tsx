import { DeleteIcon } from "@chakra-ui/icons";
import {
  Button,
  Center,
  FormControl,
  FormErrorMessage,
  FormLabel,
  Heading,
  Input,
  ListItem,
  OrderedList,
  Stack,
  useDisclosure,
  useToast,
} from "@chakra-ui/react";
import React, { useCallback, useEffect, useState } from "react";
import { GameDataApi } from "../../api/GameDataApi";

import { Game } from "../../models/game/Game";

import { GameDeleteModal } from "../GameDeleteModal";



export const AdminPage = () => {
    
const [requestGetGame, setRequestGetGame] = useState<Game[]>([]);
  const { isOpen,  onClose } = useDisclosure();
  const toast = useToast();


  const [game, setGame] = useState<Game>({
    name: "",
    genre: "",
    platform: "",
  });
  

  const onNameChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGame({ ...game, name: event.currentTarget.value });
  };
  const onGenreChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGame({ ...game, genre: event.currentTarget.value });
  };
  const onPlatformChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGame({ ...game, platform: event.currentTarget.value });
  };

  const isNameValid = () => {
    if (!game.name) {
      return false;
    }
    return game.name.length <= 40;
  };
  const isGenreValid = () => {
    if (!game.genre) {
      return false;
    }
    return game.genre.length <= 30;
  };
  const isPlatformValid = () => {
    if (!game.platform) {
      return false;
    }
    return game.platform.length <= 15;
  };


 

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

  const postGame = async () => {
    try {
      await GameDataApi.postGame(game);
      toast({
        description: "Game succesfully added.",
        duration: 3000,
        isClosable: true,
      });
    } catch (error) {
      console.error(error);
    }
  };



  return (


    <Center h="100vh" flexDirection={"column"}>
      <Heading as={"h2"} size="lg">
        Admin Panel
      </Heading>
    <Stack direction={"column"} bg="white" p={16}>
      <FormControl isInvalid={!!game.name && !isNameValid()}>
        <FormLabel>Add Game:</FormLabel>
        <Input type="text" value={game.name} onChange={onNameChanged} />
        <FormErrorMessage>Mandatory Field!</FormErrorMessage>
      </FormControl>
      {/* {!game.name&&<FormLabel>Dodaj Grę:</FormLabel>} */}
      <FormControl isInvalid={!!game.genre && !isGenreValid()}>
        <FormLabel>Add Genre:</FormLabel>
        <Input type="text" value={game.genre} onChange={onGenreChanged} />
        <FormErrorMessage>Mandatory Field!</FormErrorMessage>
      </FormControl>
      <FormControl isInvalid={!!game.platform && !isPlatformValid()}>
        <FormLabel>Add Device:</FormLabel>
        <Input type="text" value={game.platform} onChange={onPlatformChanged} />
        <FormErrorMessage>Mandatory Field!</FormErrorMessage>
      </FormControl>
      <Button
        onClick={postGame}
        className="input_submit"
        colorScheme="blue"
        disabled={!isNameValid() || !isGenreValid() || !isPlatformValid()}
      >
        Zatwierdź
      </Button>
      <OrderedList>
        <GameDeleteModal isOpen={isOpen} onClose={onClose}/>
        {requestGetGame.map(game => {
          return <ListItem>
            {game.name}, {game.genre}, {game.platform}
            <DeleteIcon onClick={onClose}>
            </DeleteIcon>
            </ListItem>
        })}
      </OrderedList>
      </Stack>
    </Center>
   
  );
};
