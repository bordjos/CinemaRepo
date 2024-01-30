import { QueryClient } from "@tanstack/react-query";

//we define the queryClient here instead of the App Component so that we could use it in multiple places
export const queryClient = new QueryClient();

export async function createNewProjection(data) {
    const response = await fetch("/projections", data);

    alert("!!!!");
  
    if (!response.ok) {
      const error = new Error("An error occurred while creating the event");
      error.code = response.status;
      error.info = await response.json();
      throw error;
    }
  
    const { event } = await response.json();
  
    return event;
  }
