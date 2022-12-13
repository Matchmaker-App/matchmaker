// import {
//     Button,
//     Modal,
//     ModalOverlay,
//     ModalContent,
//     ModalHeader,
//     ModalCloseButton,
//     ModalBody,
//     FormControl,
//     FormLabel,
//     Input,
//     ModalFooter,
//   } from "@chakra-ui/react";
  import { Box, Modal, Typography } from "@mui/material";
import React, { useState } from "react";
  
  import { DeleteData } from "../models/game/DeleteData";
  
  interface GameDeleteModalProps {
    isOpen: boolean;
    onClose: () => void;
  }
  
  export function GameDeleteModal(props: GameDeleteModalProps) {
    const [deleteData, setDelete] = useState<DeleteData>({
      deleteData: "",
    });

    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);
  
    const onDeleteChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
      setDelete({ ...deleteData, deleteData: event.currentTarget.value });
    };
    
  
    const isDeleteValid = () => {
      if (!deleteData.deleteData) {
        return false;
      }
      return deleteData.deleteData.length <= 6;
    };
  
    return (
      <>
  <Modal
  open={open}
  onClose={handleClose}
  aria-labelledby="modal-modal-title"
  aria-describedby="modal-modal-description"
>
  <Box>
    <Typography id="modal-modal-title" variant="h6" component="h2">
      Text in a modal
    </Typography>
    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
      Duis mollis, est non commodo luctus, nisi erat porttitor ligula.
    </Typography>
  </Box>
</Modal>
        {/* <Modal isOpen={props.isOpen} onClose={props.onClose}>
          <ModalOverlay />
          <ModalContent>
            <ModalHeader>Do you want to delete game data?</ModalHeader>
            <ModalCloseButton />
            <ModalBody pb={6}>
              <FormControl
                isInvalid={!!deleteData.deleteData && !isDeleteValid()}
              >
                <FormLabel>Type "DELETE" into the field to confirm.</FormLabel>
                <Input
                  type="text"
                  value={deleteData.deleteData}
                  onChange={onDeleteChanged}
                />
              </FormControl>
            </ModalBody>
  
            <ModalFooter>
              <Button
                disabled={!isDeleteValid()}
                colorScheme="blue"
                mr={3}
              >
                Delete
              </Button>
              <Button onClick={props.onClose}>Cancel</Button>
            </ModalFooter>
          </ModalContent>
        </Modal> */}
      </>
    );
  }
  