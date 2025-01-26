import { ISubcontent } from 'app/entities/subcontent/subcontent.model';

export interface IDependency {
  id: number;
  subcontent?: Pick<ISubcontent, 'id'> | null;
}

export type NewDependency = Omit<IDependency, 'id'> & { id: null };
