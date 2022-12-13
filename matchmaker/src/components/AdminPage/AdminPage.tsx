import { DeleteIcon } from "@chakra-ui/icons";
import { Box, Button, Snackbar, TextField, Typography } from "@mui/material";
import React, { useCallback, useEffect, useState } from "react";
import { GameDataApi } from "../../api/GameDataApi";
import { Game } from "../../models/game/Game";
import { DataGrid } from '@mui/x-data-grid';
import { GameDeleteModal } from "../GameDeleteModal";
import "./AdminPage.css";

export const AdminPage = () => {
  const [requestGetGame, setRequestGetGame] = useState<Game[]>([]);
  const [isToastOpen, setIsToastOpen] = useState<boolean>(false)
  const [game, setGame] = useState<Game>({
    name: "",
    genre: "",
    platform: "",
  });
  
  const handleClose = () => {
    setIsToastOpen(false)
  }

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
      setIsToastOpen(true)
    } catch (error) {
      console.error(error);
    }
  };

  return (

<div className="wholepage" >
<Box display="flex" flexDirection={"column"} marginX={'32px'} marginY={'32px'} padding={'10px'}  className="adminpage-box" >
<Typography variant="h3" gutterBottom className="title" fontFamily={'Orbitron'}>
Admin Panel
      </Typography>
      <div className="adminpage-textfield">
<TextField

onChange={onNameChanged} 

 label="Add game:"
 variant="filled"
 value={game.name}
 error={!!game.name && !isNameValid()}
 helperText={'Mandator field!'}
 />
 <TextField
onChange={onGenreChanged} 

 label="Add genre:"
 variant="filled"
 value={game.genre}
 error={!!game.genre && !isGenreValid()}
 helperText={'Mandator field!'}
 />
  <TextField
onChange={onPlatformChanged} 

value={game.platform}
 label="Add device:"
 variant="filled"
 error={!!game.platform && !isPlatformValid()}
 helperText={'Mandator field!'}
 />
 <Button variant="contained"         onClick={postGame}
        disabled={!isNameValid() || !isGenreValid() || !isPlatformValid()}>Zatwierdź</Button>
        </div>
        <Snackbar
  open={isToastOpen}
  autoHideDuration={6000}
  onClose={handleClose}
  message="Success"
/>
        <Box mt={"32px"} className="datagrid">
        <DataGrid 
        className="datagrid" 
            rows={requestGetGame}
            columns={[{
              field: "name", headerName: "Name", flex: 1/3, sortable: false, editable: false
            },
            {
              field: "genre", headerName: "Genre", flex: 1/3, sortable: false, editable: false
            },
            {
              field: "platform", headerName: "Platform", flex: 1/3, sortable: false, editable: false
            }]}
            autoHeight
            pageSize={5}
            disableColumnMenu
            disableSelectionOnClick />
          </Box>
</Box>
</div>
  );
};
