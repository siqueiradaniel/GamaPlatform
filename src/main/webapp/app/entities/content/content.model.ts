export interface IContent {
  id: number;
  name?: string | null;
  description?: string | null;
}

export type NewContent = Omit<IContent, 'id'> & { id: null };
