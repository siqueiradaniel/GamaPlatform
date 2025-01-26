export interface IExam {
  id: number;
  name?: string | null;
  description?: string | null;
}

export type NewExam = Omit<IExam, 'id'> & { id: null };
